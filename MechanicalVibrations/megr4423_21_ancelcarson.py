from numpy import linspace
from scipy.integrate import odeint
from matplotlib.pyplot import figure, plot, xlabel, ylabel, title, grid, show, legend

m = 100.0 # [kg]
c = 200.0 # [kg/s]
k = 2000.0 # [N/m]
t_int = linspace(0, 6, 101) # time interval [s]

conditions = [[0, 0.1],[.01,0],[.05,0],[0,.5]] # initial conditions
lineNames = ['(a)','(b)','(c)','(d)']
lineColors = ['-b','-g','-r','-c']

sdof = lambda x, t: [x[1], -k/m * x[0] - c/m * x[1]]

figure(num=0, figsize=(12, 9), dpi=90, facecolor='w', edgecolor='k')

for num in range(4):
    x = odeint(sdof, conditions[num], t_int);
    plot(t_int, x[:, 0], lineColors[num], label=lineNames[num], linewidth=2)

xlabel('Time, $t$ [s]')
ylabel('Position, $x(t)$ [m]')
title('Solution to the Underdamped Response by scipy\'s odeint Function')
legend(loc=0, title='Initial Cond\'s', shadow=True)
grid(True)
show()