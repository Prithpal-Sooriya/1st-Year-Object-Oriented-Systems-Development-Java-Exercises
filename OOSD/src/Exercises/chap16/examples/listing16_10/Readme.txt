Same idea: we shrink or enlarge the circle with the mouse and arrow keys

creating a Circle this time --> graphics


interesting code to keep in mind in the future
//draw a circle --> oval
/*
PARAMS:
param1 = x location;
param2 = y location;
param3 = start angle (shortest diameter);
param4 = arc angle (largest diameter)
*/
    g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius); //create a circle
    /*
    param1 = center circle in x axis
    param2 = center circle in y axis
    param3 = shortest diameter of oval (circle diameter)
    param3 = longest diameter of oval (circle diameter)
    */
