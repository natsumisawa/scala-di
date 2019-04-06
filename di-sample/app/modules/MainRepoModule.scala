package modules

import com.google.inject.AbstractModule
import repositories.{MainRepo, MainRepoImpl}

class MainRepoModule extends AbstractModule{
  override def configure() =
    bind(classOf[MainRepo]).to(classOf[MainRepoImpl])
}