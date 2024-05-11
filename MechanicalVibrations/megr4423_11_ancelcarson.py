from numpy import linspace
from scipy.integrate import odeint
from matplotlib.pyplot import figure, plot, xlabel, ylabel, title, grid, show, legend

m = 3.0 # [kg]
c = 2.0 # [kg/s]
k = 1.0 # [N/m]
t_int = linspace(0, 20, 101) # time interval [s]

x0 = [0, 0.25] # initial conditions

sdof = lambda x, t: [x[1], -k/m * x[0] - c/m * x[1]]

x = odeint(sdof, x0, t_int);

figure(num=0, figsize=(12, 9), dpi=90, facecolor='w', edgecolor='k')
plot(t_int, x[:, 0], '-b', label='Position', linewidth=2)
plot(t_int, x[:, 1], '--k', label='Velocity', linewidth=2)

xlabel('Time, $t$ [s]')
#ylabel('Position, $x(t)$ [m]')
title('Solution to the Spring-Mass-Damper System by scipy\'s odeint Function')
legend(loc=0, title='Two DOF\'s', shadow=True)
grid(True)
show()
