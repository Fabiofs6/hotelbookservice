**Hotel Booking Information**
- 
- Search booking information by city
  -
     - URL: localhost:8080/book/city
     - HTTP Method: GET
     - Example CURL: curl --request GET \
       --url http://localhost:8080/book/city \
       --header 'Content-Type: application/json' \
       --data '{
       "cityCode": 1032,
       "checkIn": "2010-01-01",
       "checkOut": "2010-01-02",
       "adultQuantity": 1,
       "childQuantity": 1
       }'
     - Response example: [{
       "id": 1,
       "cityName": "Porto Seguro",
       "rooms": [
       {
       "roomID": 0,
       "categoryName": "Standard",
       "totalPrice": 3173.08,
       "price": {
       "pricePerDayAdult": 1960.78,
       "pricePerDayChild": 1212.30
       }
       }
       ]
       }],

- Search booking information by hotel
  - 
  - URL: localhost:8080/book/hotel/{hotelId}
  - HTTP Method: GET
  - Example CURL: curl --request GET \
    --url http://localhost:8080/book/hotel/1
  - Response example: [
    {
    "id": 1,
    "cityName": "Porto Seguro",
    "rooms": [
    {
    "roomID": 0,
    "categoryName": "Standard",
    "totalPrice": 3173.08,
    "price": {
    "pricePerDayAdult": 1960.78,
    "pricePerDayChild": 1212.3
    }
    }
    ]
    }
    ]

- Swagger Information:
  - 
- http://localhost:8080/swagger-ui/