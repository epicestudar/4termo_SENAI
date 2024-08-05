<?php

use App\Http\Controllers\MeuController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ProdutoController;

Route::get('/produtos', [ProdutoController::class, 'index']);

Route::get('/', function () {
    return view('hello-world');
});

// Route::get('/produtos', function () {
//     return view('produtos');
// });

Route::get('/contato', function () {
    return view('contato');
});

Route::get('/model', [MeuController::class]);

