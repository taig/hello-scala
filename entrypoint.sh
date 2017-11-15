#!/bin/bash

set -e

sbt ";scalafmt::test;test:scalafmt::test;sbt:scalafmt::test"
sbt test