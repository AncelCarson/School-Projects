# -*- coding: utf-8 -*-

from numpy import linspace, cos, arctan, sqrt
from scipy.integrate import odeint
from matplotlib.pyplot import figure, plot, xlabel, ylabel, title, grid, show, legend

m = 100.0 # [kg]
c = 170.0 # [kg/s]
k = 750.0 # [N/m]
Fₒ = 0 # [N]
ω = 0 # [rad/s]
g = 9.81 # [m/s^2]
μ = None # [unitless]

fₒ = Fₒ/m # [m/s^2]
ωₙ = sqrt(k/m) # [rad/s]
ζ = ((c/m)/(2*ωₙ)) # [unitless]
X = fₒ/(sqrt(((ωₙ)**2 - (ω)**2)**2 + (2*ζ*ωₙ*ω)**2)) # [m]
θ = -arctan((2*ζ*ωₙ*ω)/((ωₙ)**2 - (ω)**2)) # [rad]

t_int = linspace(0, 20, 500) # time interval [s]

conditions = [[.01, 0.5],[.01, 0.5],[.01, 0.5]] # initial conditions
lineNames = ['Linear Vicous','Air Damping','Solid Damping']
lineColors = ['-b','-r','-m']

F = lambda t: fₒ * cos(ω * t)
airDamping = lambda C, v: C * (abs(v)/v) * (v**2)
solidDamping = lambda C, v, x: C * (abs(v)/v) * abs(x)

sdof = []
sdof.append(lambda x, t: [x[1], -k/m * x[0] - c/m * x[1] + F(t)])
sdof.append(lambda x, t: [x[1], -k/m * x[0] - airDamping(c/m,x[1]) + F(t)])
sdof.append(lambda x, t: [x[1], -k/m * x[0] - solidDamping(c/m,x[1],x[0])+ F(t)])

figure(num=0, figsize=(12, 9), dpi=90, facecolor='w', edgecolor='k')

for num in range(len(conditions)):
    x = odeint(sdof[num], conditions[num], t_int);
    plot(t_int, x[:, 0], lineColors[num], label=lineNames[num], linewidth=2)

xlabel('Time, $t$ [s]')
ylabel('Position, $x(t)$ [m]')
title('Comparison of Various Nonlinear Dampers by scipy\'s odeint Function')
legend(loc=0, title='Damping Types', shadow=True)
grid(True)
show()