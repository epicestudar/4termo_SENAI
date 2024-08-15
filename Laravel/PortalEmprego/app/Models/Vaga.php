<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Vaga extends Model
{
    use HasFactory;

    protected $fillable = [
        'titulo', 'descricao', 'localizacao', 'salario', 'empresa'
    ];

    public function inscricoes() {
        return $this->hasMany(Inscricao::class);
    }
}
