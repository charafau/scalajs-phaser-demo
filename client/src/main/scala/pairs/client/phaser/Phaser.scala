package pairs.client.phaser

import scala.scalajs.js
import js.annotation._

@js.native
@JSName("Phaser.Game")
class Game(width: Int = 800, height: Int = 600,
    renderer: Int = Phaser.AUTO,
    parent: String = "") extends js.Object {
  val state: StateManager = js.native

  val add: GameObjectFactory = js.native
}

@js.native
@JSName("Phaser.StateManager")
class StateManager extends js.Object {
  def add(key: String, state: State): Unit = js.native

  def start(key: String): Unit = js.native
}

@js.native
@JSName("Phaser.State")
class State extends js.Object {
  protected final def game: Game = js.native
  protected final def load: Loader = js.native

  def preload(): Unit = js.native
  def create(): Unit = js.native
}

@js.native
@JSName("Phaser.Loader")
class Loader extends js.Object {
  def image(key: String, url: String = js.native,
      overwrite: Boolean = false): this.type = js.native
}

@js.native
@JSName("Phaser.GameObjectFactory")
class GameObjectFactory(game: Game) extends js.Object {
  def sprite(x: Double = 0, y: Double = 0,
      key: String = js.native): Sprite = js.native

  def graphics(x: Double = 0, y: Double = 0): Graphics = js.native
}

@js.native
@JSName("Phaser.Point")
class Point(var x: Double = 0, var y: Double = 0) extends js.Object

@ScalaJSDefined
trait PointLike extends js.Object {
  def x: Double
  def y: Double
}

@js.native
@JSName("Phaser.Graphics")
class Graphics protected () extends js.Object {
  def clear(): Unit = js.native
  def beginFill(color: Int): Unit = js.native
  def endFill(): Unit = js.native
  def drawPolygon(path: js.Array[PointLike]): Unit = js.native
}

@js.native
@JSName("Phaser.Events")
class Events(sprite: Sprite) extends js.Object {
  val onInputDown: Signal[js.Function1[Sprite, _]] = js.native
}

@js.native
trait ComponentCore extends js.Object {
  val events: Events = js.native
}

@js.native
trait InputEnabled extends js.Object {
  def inputEnabled: Boolean = js.native
  def inputEnabled_=(value: Boolean): Unit = js.native
}

@js.native
@JSName("Phaser.Sprite")
class Sprite protected () extends pixi.Sprite
    with ComponentCore with InputEnabled {

}

@js.native
@JSName("Phaser.Signal")
class Signal[ListenerType <: js.Function] extends js.Object {
  def add(listener: ListenerType): Unit = js.native
}

@js.native
object Phaser extends js.Object {
  val AUTO: Int = js.native
}
