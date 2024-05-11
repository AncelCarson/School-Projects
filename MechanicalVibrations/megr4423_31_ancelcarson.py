# -*- coding: utf-8 -*-

from numpy import linspace, cos, arctan, sqrt
from scipy.integrate import odeint
from matplotlib.pyplot import figure, plot, xlabel, ylabel, title, grid, show, legend

m = 100.0 # [kg]
c = 150.0 # [kg/s]
k = 1000.0 # [N/m]
Fₒ = 75 # [N]
ω = 10 # [rad/s]

fₒ = Fₒ/m # [m/s^2]
ωₙ = sqrt(k/m) # [rad/s]
ζ = ((c/m)/(2*ωₙ)) # [unitless]
X = fₒ/(sqrt(((ωₙ)**2 - (ω)**2)**2 + (2*ζ*ωₙ*ω)**2)) # [m]
θ = -arctan((2*ζ*ωₙ*ω)/((ωₙ)**2 - (ω)**2)) # [rad]

t_int = linspace(0, 7, 201) # time interval [s]

conditions = [[-.01, 0.1],[.01,-.1],[.05,0],[0,.15]] # initial conditions
lineNames = ['(a)','(b)','(c)','(d)','xₚ(t)']
lineColors = ['-b','-g','-r','-c','--k']

sdof = lambda x, t: [x[1], -k/m * x[0] - c/m * x[1] + (fₒ * cos(ω * t))]

figure(num=0, figsize=(12, 9), dpi=90, facecolor='w', edgecolor='k')

for num in range(4):
    x = odeint(sdof, conditions[num], t_int);
    plot(t_int, x[:, 0], lineColors[num], label=lineNames[num], linewidth=2)

plot(t_int, -(X * cos((ω * t_int) + θ)), lineColors[4], label=lineNames[4], linewidth=2)

xlabel('Time, $t$ [s]')
ylabel('Position, $x(t)$ [m]')
title('Solution to the Spring-Mass-Damper System by scipy\'s odeint Function')
legend(loc=0, title='Initial Cond\'s', shadow=True)
grid(True)
show()