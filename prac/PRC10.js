// GNU GENERAL PUBLIC LICENSE
// Version 3, 29 June 2007
//
// Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
// Everyone is permitted to copy and distribute verbatim copies
// of this license document, but changing it is not allowed.


// Consulta 1
db.restaurants.find();

// Consulta 2
db.restaurants.find({}, {restaurant_id: 1, name: 1, borough: 1, cuisine: 1});

// Consulta 3
db.restaurants.find({}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1, _id: 0});

// Consulta 4
db.restaurants.find({}, {borough: "Bronx"});

// Consulta 5
db.restaurants.find({}, {borough: "Bronx"}).limit(5);

// Consulta 6
db.restaurants.find({}, {borough: "Bronx"}).skip(5).limit(5);

// Consulta 7
db.restaurants.find({"grades.score": {$gt: 90}});

// Consulta 8
db.restaurants.find({"grades.score": {$gt: 80, $lt: 100}});

// Consulta 9
db.restaurants.find({"address.coord": {$lt: -95.754168}});

// Consulta 10
db.restaurants.find({
    $and: [
        {"cuisine": {$ne: "American "}},
        {"grades.score": {$gt: 70}},
        {"address.coord": {$lt: -65.754168}}
    ]
});

// Consulta 11
db.restaurants.find({
    $and: [
        {"cuisine": {$ne: "American "}},
        {"grades.grade": "A"},
        {"borough": {$ne: "Brooklyn"}}
    ]
});

// Consulta 12
db.restaurants.find({
    $and: [
        {"borough": "Bronx"},
        {$or: [
            {"cuisine": "American "},
            {"cuisine": "Chinese"}
            ]
        }
    )

// Consulta 13
db.restaurants.find().sort({name: 1});

// Consulta 14
db.restaurants.find().sort({name: -1});

// Consulta 15
db.restaurants.find().sort({cuisine: 1, borough: -1});