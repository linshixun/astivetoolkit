# Astive Toolkit

Astive is a toolkit and server for Java, with an extensible architecture for developing, maintaining, and deploying voice applications. Build high-quality products over Asterisk® PBX with the Astive developer solutions.

Current status in BuildHive: [![Build Status](https://buildhive.cloudbees.com/job/psanders/job/astivetoolkit/badge/icon)](https://buildhive.cloudbees.com/job/psanders/job/astivetoolkit/)

## Requirements

* Java 1.5+
* Maven 3.x.x+
* Asterisk 1.8+
* Git (optional)

## Communications diagram

![Astive Communications Diagram](http://astivetoolkit.org/data/uploads/astive_communications_diagram.png)

## Features 

* Multi-IVR applications
* Asterisk 1.8 >
* Application-Server like operations(start, stop, undeploy, deploy...)
* Advanced API's for IVR creation
* Event-driven architecture
* Support for FastAGI (AMI on the way)
* Open Source
* Well documented

## Getting Astive

A pre-assembled version of ATK can be found in [the website](http://astivetoolkit.org/downloads). You can also build ATK as follows:

```bash
git clone https://github.com/psanders/astivetoolkit.git
cd astivetoolkit
./assembly
```

The script will generate the Astive Server and the SDK. You can find the assemblies in folder 'dist'.

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
* Please see our [Contribution Documents](https://github.com/psanders/astivetoolkit/blob/dev/CONTRIBUTING.md) 
* [Contributors](https://github.com/psanders/astivetoolkit/contributors)


### Copyright

Copyright (C) 2010-2014 by [PhonyTive LLC](http://phonytive.com). Apache License, Version 2.0 (see LICENSE for details).

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/psanders/astivetoolkit/trend.png)](https://bitdeli.com/free "Bitdeli Badge")
