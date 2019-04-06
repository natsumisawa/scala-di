package repositories

case class User(id: Int, name: String)

trait UserRepository {
  def listUser: User
}

object UserRepositoryImpl extends UserRepository {
  def listUser: User = User(1, "natsumi")
}

object UserService {
  val userRepository: UserRepository = UserRepositoryImpl // ここでimplを参照しているのが問題

  userRepository.listUser
}