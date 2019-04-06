package repositories

import models.User

class MainRepoImpl extends MainRepo {
  def list: User = User(1, "natsu")
}
