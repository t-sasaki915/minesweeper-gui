package net.st915.scalikeawt

import cats.effect.{ExitCode, IO}

package object system {

  def exitUpdate[Model](exitCode: ExitCode)(using Model): IO[Model] =
    IO(System.exit(exitCode.code)) >> IO(summon)

}
