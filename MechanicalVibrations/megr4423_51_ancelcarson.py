# -*- coding: utf-8 -*-

from numpy import linspace, cos, sin, arctan, sqrt, exp
from scipy.integrate import odeint
from matplotlib.pyplot import figure, plot, xlabel, ylabel, title, grid, show, legend

m = 1.0 # [kg]
c = 1.0 # [kg/s]
k = 7.0 # [N/m]
Fₒ = 0 # [N]
ω = 0 # [rad/s]
g = 9.81 # [m/s^2]
μ = None # [unitless]
imp = 1.25 # [N*s]
tₒ = 2.5 # [s]

fₒ = Fₒ/m # [m/s^2]
ωₙ = sqrt(k/m) # [rad/s]
ζ = ((c/m)/(2*ωₙ)) # [unitless]
X = fₒ/(sqrt(((ωₙ)**2 - (ω)**2)**2 + (2*ζ*ωₙ*ω)**2)) # [m]
θ = -arctan((2*ζ*ωₙ*ω)/((ωₙ)**2 - (ω)**2)) # [rad]
ωₔ = ωₙ*sqrt(1-ζ**2) # [rad/s]
B = imp/(m*ωₔ) 

t_int = linspace(0, 10, 250) # time interval [s]

conditions = [[1.0, 0.0],[1.0, 0.0]] # initial conditions
lineNames = ['Free Response','Forced Response',]
lineColors = ['--k','-k',]

F = lambda t: fₒ * cos(ω * t)
airDamping = lambda C, v: C * (abs(v)/v) * (v**2)
solidDamping = lambda C, v, x: C * (abs(v)/v) * abs(x)

step = lambda t, tₓ: 1*(t>tₓ)

xₚ = lambda t: B*exp(-ζ*ωₙ*(t-tₒ))*sin(ωₔ*(t-tₒ))*step(t,tₒ)

sdof = []
sdof.append(lambda x, t: [x[1], -k/m * x[0] - c/m * x[1]])

figure(num=0, figsize=(12, 9), dpi=90, facecolor='w', edgecolor='k')

for num in range(1):
    x = odeint(sdof[num], conditions[num], t_int)
    plot(t_int, x[:, 0], lineColors[num], label=lineNames[num], linewidth=2)

plot(t_int, x[:, 0] + xₚ(t_int), lineColors[1], label=lineNames[1], linewidth=2)

xlabel('Time, $t$ [s]')
ylabel('Position, $x(t)$ [m]')
title('Solution to the Impulse Function')
legend(loc=0, title='Impulse Input', shadow=True)
grid(True)
show()