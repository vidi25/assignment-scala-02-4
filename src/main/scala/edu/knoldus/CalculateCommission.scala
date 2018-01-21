package edu.knoldus

import scala.reflect.runtime.universe._

abstract class Commission() {
  val value: Int
}

case class ClientSideCommission(override val value: Int) extends Commission

case class StreetSideCommission(override val value: Int) extends Commission

private sealed trait CommissionDisplay[T <: Commission] {
  def totalDisplayCommission: String
}

object CalculateCommission {

  private implicit class ListExtension[T <: Commission : TypeTag](val list: List[T]) extends CommissionDisplay[T] {
    def totalDisplayCommission: String = {
      typeOf[T] match {
        case comm if comm =:= typeOf[Commission] =>
          s"The total mingled commission value = ${list.map(_.value).sum}"
        case comm if comm <:< typeOf[ClientSideCommission] =>
          s"The total client commission value = ${list.map(_.value).sum}"
        case comm if comm <:< typeOf[StreetSideCommission] =>
          s"The total street commission value = ${list.map(_.value).sum}"
      }
    }
  }

  class TotalCommission[T <: Commission : TypeTag](val list: List[T]) {
    def getTotalCommission: String = {
      list.totalDisplayCommission
    }
  }

}
