package services

import javax.inject.Inject

import com.google.inject.{AbstractModule, Guice, Injector}

trait Marathon {
  def value: String
}

class TokyoMarathon extends Marathon {
  val value = "tokyo"
}

class HonoluluMarathon extends Marathon {
  val value = "hawaii"
}

// Marathon -> TokyoMarathon
// Marathon -> HonoluluMarathon

// guice
class TokyoMarathonModule extends AbstractModule {
  override def configure = {
    bind(classOf[Marathon]).to(classOf[TokyoMarathon])
  }
}

class HonoluluMarathonModule extends AbstractModule {
  override def configure = {
    bind(classOf[Marathon]).to(classOf[HonoluluMarathon])
  }
}

trait MarathonRace {
  def venue(): Unit
}

// @Inject 注入可能
class MarathonRaceImpl @Inject()(marathon: Marathon) extends MarathonRace {
  def venue = {
    println(marathon.value)
  }
}

class MarathonRaceModule extends AbstractModule {
  override def configure() = {
    bind(classOf[MarathonRace]).to(classOf[MarathonRaceImpl])
  }
}

object Main extends App {
  def main: Unit = {
    // 注射器
    val injector: Injector = Guice.createInjector(new TokyoMarathonModule, new MarathonRaceModule)
    val marathonRace = injector.getInstance(classOf[MarathonRace])
    marathonRace.venue()
    // > tokyo

    val ingectorHonolulu = Guice.createInjector(new HonoluluMarathonModule, new MarathonRaceModule)
    val marathonRaceHonolulu = ingectorHonolulu.getInstance(classOf[MarathonRace])
    marathonRaceHonolulu.venue()
    // > honolulu
  }
}