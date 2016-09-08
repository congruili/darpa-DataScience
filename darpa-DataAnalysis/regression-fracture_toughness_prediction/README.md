# Regression-fracture toughness prediction

**Please note: for security purposes, all the numerical values in the data are fake.** 

`.xlsx` contains the original data. `AdjWork` which means the final fracture toughness is the dependent variable. 
`Surface Preperation` column is a factor variable; all the other variables are numerical. 
Since the `cv.glmnet` command in the `glmnet` package used in the R script could not take factors, I converted `Surface Preperation` into 6 dummy variables (`sp1` through `sp6` in the `.csv`). 
`Surface Preperation` is deleted since it's no longer needed and `sp1` through `sp6` could be treated as numerical variables, same as the other features. 
This results in the `.csv`, which is the one used by the R script. 

When importing the `.csv` file into RStudio, make sure you include these arguments:
**`header = TRUE, row.names=1`**.

The `R-squared` and `adjusted R-squared` values are calculated for each model, which are used to measure the performance of the model. 

