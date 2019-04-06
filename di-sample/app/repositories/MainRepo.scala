package repositories

import models.User

trait MainRepo {
  def list: User
}
