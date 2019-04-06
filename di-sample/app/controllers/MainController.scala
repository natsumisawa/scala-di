package controllers

import javax.inject._
import play.api.mvc._
import services.MainService

@Singleton
class HomeController @Inject()(cc: ControllerComponents, service: MainService) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(service.listUser(1).head.name))
  }
}