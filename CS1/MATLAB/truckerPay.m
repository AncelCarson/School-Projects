function result = truckerPay(miles)
if miles <= 1500
    perMile = .7;
elseif miles <= 2000
    perMile = .73;
elseif miles <=3000
    perMile = .765;
else
    perMile = .8;
end
result = miles*perMile;