# Astive Toolkit

Astive is a toolkit and server for Java, with an extensible architecture for developing, maintaining, and deploying voice applications. Build high-quality products over Asterisk® PBX with the Astive developer solutions.

## Requirements

* Java 1.6+
* Maven 3.x.x+
* Asterisk 1.8+

## Communications diagram

![Astive Communications Diagram](http://astivetoolkit.org/data/uploads/astive_communications_diagram.png)

## Features 

* Multi-IVR applications.
* Asterisk 1.8 >
* Application-Server like operations(start, stop, undeploy, deploy...).
* Advanced API's for IVR creation.
* Event-driven architecture.
* Support for FastAGI (AMI on the way).
* Open Source.
* Well documented.

## Getting Astive

A pre-assembled version of ATK can be found in [the website](http://astivetoolkit.org/downloads). You can also build ATK as follows:

```bash
git clone https://github.com/psanders/astivetoolkit.git
cd astivetoolkit
./assembly
```

## Example

A simple application:

```java
public class App extends Astivlet {
    @Override
    public void service(AstivletRequest request, AstivletResponse response) {
        try {
            response.answer();
            response.streamFile("tt-monkeys");
            response.hangup();
        } catch (AgiException ex) {
            out.print(ex.getMessage());
        }
    }
}
```

Looking for something more advanced? check out the examples in [the website](http://astivetoolkit.org/downloads).

## Author

Core team:

* [Pedro Sanders](https://github.com/psanders)
* [Eudris Cabrera](https://github.com/ecabrerar)

## Contributions
* See our contributions guidelines on `CONTRIBUTING` 
* [Contributors](https://github.com/psanders/astivetoolkit/contributors)


### Copyright

Copyright (C) 2010-2013 by [PhonyTive LLC](http://phonytive.com). Apache License, Version 2.0 (see LICENSE for details).
