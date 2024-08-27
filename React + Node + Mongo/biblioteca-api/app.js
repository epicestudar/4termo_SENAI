const express = require('express');
const bodyParser = require('body-parser');
const livroRoutes = require('./routes/livrosRoutes');
require("dotenv").config();
require("./config/database");

const app = express();

app.use(bodyParser.json());

app.use('/livros', livroRoutes);

module.exports = app;