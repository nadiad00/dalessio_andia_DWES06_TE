<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\GatewayController;


//Rutas pokémon
Route::get('/pokemon', [GatewayController::class, 'getAllPokemon']);
Route::get('/pokemon/{id}', [GatewayController::class, 'getPokemonById']);
Route::get('/pokemon/tipo/{tipo}', [GatewayController::class, 'getPokemonByType']);
Route::get('/pokemon/gen/{gen}', [GatewayController::class, 'getPokemonByGen']);

//Rutas equipos
Route::get('/equipos', [GatewayController::class, 'getAllTeams']);
Route::get('/equipos/{id}', [GatewayController::class, 'getTeamById']);
Route::post('/equipos/post', [GatewayController::class, 'createTeam']);
Route::put('/equipos/put/{id}', [GatewayController::class, 'updateTeam']);
Route::delete('/equipos/delete/{id}', [GatewayController::class, 'deleteTeam']);
