package ru.martemyanov.social.model

import _root_.java.math.MathContext
import _root_.net.liftweb.mapper._
import _root_.net.liftweb.util.Empty

class Account extends LongKeyMapper[Account] with IdPK {
	def getSingleton = Account

	object owner extends MappedLongForeignKey(this, User) {
		override def dbIndexed_? = true
	}

	object is_public extends MappedBoolean(this) {
		override def defaultValue = false
	}

	object balance extends MappedDecimal(this, MathContext.DECIMAL64, 2)

	object name extends MappedString(this, 100)
	object description extends MappedString(this, 300)

	def admins = AccountAdmin.findAll(By(AccountAdmin.account, this.id))
	def addAdmin(user: User) = AccountAdmin.create.account(this).adiministrator(user).save()
	def viewers = AccountViewer.findAll(By(AccountViewer.account, this.id))
	def entries = Expense.getByAcct(this, Empty, Empty, Empty)
	def tags = Tag.findAll(By(Tag.account, this.id))
	def notes = AccountNotes.findAll(By(AccountNotes.account, this.id))
}

object Account extends Account with LongKeyedMetaMapper[Account] {
	def findByName(owner:User, name: String) : List[Account] = 
		Account.findAll(By(Account.user, owner.id.is), By(Account.name, name))
}