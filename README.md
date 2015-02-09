# ATLChecker
A simple update check plugin for Modpacks released on the [ATLauncher](http://atlauncher.com). Any modpacks released on the [ATLauncher](http://atlauncher.com) are welcome to use this mod freely.

Installation & Setup
-----
1. Download from [Releases page](https://github.com/nodecraft/ATLChecker/releases)
2. Add the ATLChecker.jar file to /mods folder.
3. Edit /config/ATLChecker.cfg file to match messages as desired. You may need to run the mod once to generate this file.

*NOTE: you will get alerts about the pack being out of date when working with a dev release. The ATLauncher API does not provide public details regarding dev versions*

Configuration
-----
`Pack` - A string which references the nice name of your pack. This will be the same string as found on the ATLauncher website. For example *Bytesize* is the slug for www.atlauncher.com/pack/Bytesize
`Current Version` - A string which references the current version of the pack.
`Console Message` - Message to output in server console, when out of date.
`Console Output` - Boolean to enable server console output, when out of date
`Operator Message` - Message to send to server OP, when out of date
`Operator Output` - Boolean to enable server OP message, when out of date
`API Failure Message` - Message returned if ATLauncher API request fails
