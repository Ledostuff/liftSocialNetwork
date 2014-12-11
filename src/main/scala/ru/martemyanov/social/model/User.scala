package ru.martemyanov.social.model

import _root_.net.liftweb.mapper._

class User extends MegaProtoUser[User] {
	def getSingleton = User

	def getAllAccounts: List[Account] = 
		Account.findAll(By(Account.owner, this.id))
}

object User extends User with MetaMegaProtoUser[User] {
	override def dbTableName = "users"

	override def loginXhtml = 
		<lift:surround with="default" at="content">
			{super.loginXhtml}
		</lift:surround>

	override def signupXhtml(user : User) = 
		<lift:surround with="default" at="content">
			{super.signupXhtml(user)}
		</lift:surround>
}