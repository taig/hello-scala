#!/bin/bash

sbt "scalafmt::test;test:scalafmt::test;sbt:scalafmt::test"
sbt test