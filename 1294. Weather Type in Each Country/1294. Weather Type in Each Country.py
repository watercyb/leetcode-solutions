#
# Problem: 1294. Weather Type in Each Country
# Difficulty: Easy
# Link: https://leetcode.com/problems/weather-type-in-each-country/
# Language: python3
# Date: 2026-04-15


import pandas as pd

def weather_type(countries: pd.DataFrame, weather: pd.DataFrame) -> pd.DataFrame:
    weather=weather[weather['day'].dt.strftime('%y-%m')=='19-11']
    weather=weather.groupby('country_id')['weather_state'].mean().reset_index()
    weather['weather_type']=weather['weather_state'].apply(lambda x: 'Cold' if x<=15 else 'Warm' if x<25 else 'Hot')
    countries=pd.merge(countries, weather, how='inner', on='country_id')
    return countries[['country_name', 'weather_type']]
