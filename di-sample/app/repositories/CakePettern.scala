// trait
trait UsesUserRepository {
  val userRepository: UserRepository
}

trait UserRepository {
  def listUser: String
}

// impl
object UserRepositoryImpl extends UserRepository {
  def listUser: String = "name"
}

trait MixInUserRepository extends UsesUserRepository {
  val userRepository = UserRepositoryImpl
}

trait UserService extends UsesUserRepository
object userService extends UserService with MixInUserRepository