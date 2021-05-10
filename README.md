# ninie-io

A funny discord bot that meows, sings and keeps scores.

Written in kotlin, based on spring boot & discord4j.
Data management to be introduced through some Azure functions.

GitHub action deploys to azure app service on main push.
Executable in local if provided a valid bot token & prefix

#TODOs :
 
Impl more commands: score mgt, rio check\
Connect to azure & move static data (I.E: songs) to DB, make it updatable through commands\
Impl a functionality to make a voice channel usable as 'temp channel builder'\
make prefix customizable\
on server join, send help command\
restrict to a server-specific  a channel ?\
remove unknown command & improve response ?



