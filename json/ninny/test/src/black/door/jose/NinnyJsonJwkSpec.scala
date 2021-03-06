package black.door.jose

import black.door.jose.json.ninny.JsonSupport
import black.door.jose.jwk.Jwk
import io.github.kag0.ninny._

class NinnyJsonJwkSpec extends JwkSpec with JsonSupport {
  def jwkSerializer: Mapper[Jwk, String] = k => Right(Json.render(k.toSomeJson))

  implicit def jwkDeserializer: Mapper[String, Jwk] =
    Json.parse(_).to[Jwk].toEither.left.map(_.getMessage)
}
