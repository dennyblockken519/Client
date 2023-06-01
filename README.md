# MoonScape Client

---

## Setup Guide

First, make sure you're using JDK 1.8 in `File` _->_ `Project Structure`, I recommend Amazon Corretto.

![corretto](https://i.imgur.com/qLpVKYe.png)

Now the client needs to be installed. This only needs to be done once, just install the client using
the `Install Client` Maven task configuration.

![Install Client](https://i.imgur.com/rAdbx8q.png)

Then you should be able to use the `Run Client` configuration to launch the client.

![Run Client](https://i.imgur.com/MfoPI4i.png)

## Producing a JAR

Since we use the RuneLite launcher, we don't typically need to produce JARs. But in case you do, just run
the `Package Client` Maven task configuration.

![Package Client](https://i.imgur.com/KUfa1Ap.png)

The JAR produced will be in the directory path `runelite-client/target/client-1.5.22.1-shaded.jar`