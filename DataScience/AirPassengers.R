#Load the packages
install.packages("ggfortify")
install.packages("tseries")
#*
install.packages("forecast")
install.packages("ggplot2")
install.packages("dplyr")
install.packages("gridExtra")
install.packages("corrplot")
install.packages("fpp")
install.packages("fma")
install.packages("flexdashboard")
library(ggfortify)
library(tseries)
library(forecast)
library(ggplot2)
library(dplyr)
library(gridExtra)
library(corrplot)
library(fpp)
library(fma)

#Setup the data
data(AirPassengers)
AP <- AirPassengers

#Display the data
AP

#Check data for missing values
sum(is.na(AP))

#Check the frequency
frequency(AP)

#Check the cycle
cycle(AP)

#Summary
summary(AP)

#Plot Raw Data
plot(AP,xlab="Date", ylab = "Passenger numbers per 1000's",main="Air Passenger from 1949 to 1961")

#BoxPlot
boxplot(AP~cycle(AP),xlab="Date", ylab = "Passenger Numbers (1000's)" ,main ="Monthly Air Passengers Boxplot from 1949 to 1961")

#Decompose Data
decomposeAP <- decompose(AP,"multiplicative")
autoplot(decomposeAP)

#Arima
arimaAP <- auto.arima(AP)
arimaAP
ggtsdiag(arimaAP)

#Arima Forecast
forecastAP<- forecast(arimaAP, level = c(95),h=36)
autoplot(forecastAP)

#Linear Regression
autoplot(AP) + geom_smooth(method="lm")+ labs(x ="Date", y = "Passenger numbers (1000's)", title="Air Passengers from 1949 to 1961") 
