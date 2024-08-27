const express = require('express');
const bodyParser = require('body-parser');
const livroRoutes = require('./routes/livrosRoutes');
const cors = require('cors');
require("dotenv").config();
require("./config/database");

const app = express();

app.use(bodyParser.json());
app.use(cors());

app.use('/livros', livroRoutes);

module.exports = app;