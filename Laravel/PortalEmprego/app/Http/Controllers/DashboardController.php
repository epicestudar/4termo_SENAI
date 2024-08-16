<?php

namespace App\Http\Controllers;
use App\Models\Vaga;
use Illuminate\Http\Request;

class DashboardController extends Controller
{
    public function index(Request $request) {
        $search = $request->input('search');
        $vagas = Vaga::when($search, function($query, $search) {
            return $query->where('titulo', 'like', "%{$search}%")
            ->orWhere('descricao', 'like', "%{$search}%")
            ->orWhere('localizacao', 'like', "%{$search}%")
            ->orWhere('empresa', 'like', "%{$search}%");
        })->get();

        return view('usuarios.dashboard', compact('vagas'));
    }
}
