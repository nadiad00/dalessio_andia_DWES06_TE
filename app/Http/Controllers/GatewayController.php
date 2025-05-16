<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class GatewayController extends Controller
{
    //ruta del controller pokémon del microservicio
    private $microUrlPokemon = 'http://localhost:8080/pokemon';

    //ruta del controller equipo del microservicio
    private $microUrlEquipos = 'http://localhost:8080/equipos';

    //Método para obtener todos los pokémon
    public function getAllPokemon() {
        $respuesta = Http::get("{$this->microUrlPokemon}/get");

        return response()->json($respuesta->json(), $respuesta->status());
    }

    //Método para obtener pokémon según su id
    public function getPokemonById($id) {
        $respuesta = Http::get("{$this->microUrlPokemon}/get/{$id}");

        return response()->json($respuesta->json(), $respuesta->status());
    }

    //Método para obtener pokémon según su tipo
    public function getPokemonByType($tipo) {
        $respuesta = Http::get("{$this->microUrlPokemon}/getType/{$tipo}");

        return response()->json($respuesta->json(), $respuesta->status());
    }

    //Método para obtener pokémon según su generación
    public function getPokemonByGen($gen) {
        $respuesta = Http::get("{$this->microUrlPokemon}/getGen/{$gen}");

        return response()->json($respuesta->json(), $respuesta->status());
    }

    //Método para obtener todos los equipos
    public function getAllTeams() {
        $respuesta = Http::get("{$this->microUrlEquipos}/get");

        return response()->json($respuesta->json(), $respuesta->status());
    }

    //Método para obtener equipos según su id
    public function getTeamById($id) {
        $respuesta = Http::get("{$this->microUrlEquipos}/get/{$id}");

        return response()->json($respuesta->json(), $respuesta->status());
    }

    //Método para crear nuevos equipos
    public function createTeam(Request $request) {
        $respuesta = Http::post("{$this->microUrlEquipos}/post", $request->all());

        return response()->json($respuesta->json(), $respuesta->status());
    }

    //Método para modificar equipo existente
    public function updateTeam(Request $request, $id) {
        $respuesta = Http::put("{$this->microUrlEquipos}/put/{$id}", $request->all());

        return response()->json($respuesta->json(), $respuesta->status());
    }

    //Método para eliminar equipo existente
    public function deleteTeam($id) {
        $respuesta = Http::delete("{$this->microUrlEquipos}/delete/{$id}");

        return response()->json($respuesta->json(), $respuesta->status());
    }


}
