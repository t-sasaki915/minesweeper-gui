package net.st915.scalikeawt

import cats.effect.IO

case class MenuItem[Model, Msg](
  label: String,
  action: Model => IO[Msg],
  model: Model
)
