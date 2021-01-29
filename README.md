Application A1 defines a dangerous level permission In addition, A1 defines an activity containing two
read-only text views and two buttons. The buttons, when selected, will first show a short
toast message, then broadcast two different intents (e.g., attractions and restaurants)
depending on the button pressed. The text views describe the meaning of the buttons to
the device user.

2. Application A2 receives the intents; however, this app will respond to the
intents only if the sender owns permission “edu.uic.cs478.sp2020.chitowndanger”.
Depending on the kind of intent that was received, A2 will launch one of two activities.
The first activity (attractions) displays information about 8 points of interest in the city of
Chicago, Illinois (e.g., the Lincoln Park Zoo, Navy Pier, the Museum of Science and
Industry, the Art Institute, the TILT!, etc.) The second activity shows at least 6
restaurants located within Chicago’s city limits. Both activities contain two fragments,
whose behavior is described below. In addition, application A2 maintains an options
menu and an action bar. The action bar shows the name of the application (your choice)
and the overflow area. The options menu allows a device user to switch between
attractions and restaurants. This menu should be clearly accessible from the overflow
area.
