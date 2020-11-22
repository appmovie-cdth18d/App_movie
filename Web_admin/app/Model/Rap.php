<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class Rap extends Model
{
    use SoftDeletes;

    protected $dates = ['deleted_at'];
    
    protected $fillable = [
    	'Tenrap',
		'hang',
		'cot'
    ];

    public function ghes(){
    	return $this->hasMany('Model\Ghe','rap_id','id');
    }
    public function lichchieus(){
    	return $this->hasMany('Model\LichChieu','rap_id','id');
    }
}
