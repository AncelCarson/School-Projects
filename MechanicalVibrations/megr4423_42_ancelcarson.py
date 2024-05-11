# -*- coding: utf-8 -*-

from numpy import linspace, cos, arctan, sqrt
from scipy.integrate import odeint
from matplotlib.pyplot import figure, plot, xlabel, ylabel, title, grid, show, legend

m = 100.0 # [kg]
c = 17.0 # [kg/s]
k = 3000.0 # [N/m]
Fₒ = 0 # [N]
ω = 0 # [rad/s]
g = 9.81 # [m/s^2]
μ = None # [unitless]

fₒ = Fₒ/m # [m/s^2]
ωₙ = sqrt(k/m) # [rad/s]
ω = ωₙ * .25 # [rad/s]
ζ = ((c/m)/(2*ωₙ)) # [unitless]
X = fₒ/(sqrt(((ωₙ)**2 - (ω)**2)**2 + (2*ζ*ωₙ*ω)**2)) # [m]
θ = -arctan((2*ζ*ωₙ*ω)/((ωₙ)**2 - (ω)**2)) # [rad]

t_int = linspace(0, 10, 250) # time interval [s]

conditions = [[.01, 0.5],[.01, 0.5]] # initial conditions
lineNames = ['Linear Viscous','Couloumb Damping']
lineColors = ['-b','-r']

F = lambda t: fₒ * cos(ω * t)
damping = lambda C, v: C * (abs(v)/v)
sdof = []
sdof.append(lambda x, t: [x[1], -k/m * x[0] - c/m * x[1] + F(t)])
sdof.append(lambda x, t: [x[1], -k/m * x[0] - damping(c/m,x[1]) + F(t)])

figure(num=0, figsize=(12, 9), dpi=90, facecolor='w', edgecolor='k')

for num in range(len(conditions)):
    x = odeint(sdof[num], conditions[num], t_int);
    plot(t_int, x[:, 0], lineColors[num], label=lineNames[num], linewidth=2)

xlabel('Time, $t$ [s]')
ylabel('Position, $x(t)$ [m]')
title('Comparison of Linear and Coulomb Damping by scipy\'s odeint Function')
legend(loc=0, title='Damping Types', shadow=True)
grid(True)
show()