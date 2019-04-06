package services

import javax.inject.Inject
import models.User
import repositories.MainRepo

class MainService @Inject()(mainRepo: MainRepo) {
  def listUser(id: Int): List[User] = {
    if(id == 1) List(mainRepo.list)
    else Nil
  }
}