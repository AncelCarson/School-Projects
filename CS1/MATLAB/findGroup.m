function result = findGroup(value)
if value<25 
   result = 'young';
elseif value<45
   result = 'mature';
elseif value<60 
   result = 'old';
else
   result = 'over the hill';
end