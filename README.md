# ninie-io

A funny discord bot that meows, sings and keeps scores.

Written in kotlin, based on spring boot & discord4j.
Data management to be introduced through some Azure functions.

GitHub action deploys to heroku on main push.
Executable in local if provided a valid bot token

TODOs:
[TECH] :
Get to 100% uptime (heroku wakeup)\
think whether using action for non-secret env related conf is best

[FUNCTIONAL]
Impl more commands: score mgt, rio check\
Connect to azure & move static data (I.E: songs) to DB, make it updatable through commands\
Impl a functionality to make a voice channel usable as 'temp channel builder'\
make prefix customizable\
on server join, send help command\
make ninie bindable to a channel ?\
remove unknown command & improve response



