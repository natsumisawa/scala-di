package services

import models.User
import org.scalatest._
import org.scalatest.mockito.MockitoSugar
import repositories.MainRepo
import org.mockito.Matchers._
import org.mockito.Mockito._

class MainServiceSpec extends FunSpec with MustMatchers with MockitoSugar {

  val repoMock = mock[MainRepo]
  val service = new MainService(repoMock)

  describe("listUser") {
    it("idが1だったらuser情報を返す") {
      val expected = User(1, "natsu")
      when(repoMock.list).thenReturn(expected)
      service.listUser(1).head mustBe expected
    }

    it("idが1以外だったらNilを返す") {
      service.listUser(3) mustBe Nil
    }
  }
}
