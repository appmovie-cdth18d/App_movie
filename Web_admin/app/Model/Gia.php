<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class Gia extends Model
{
	use SoftDeletes;
	
	protected $dates = ['deleted_at'];
	
    protected $fillable = [
    	'Tenloaigia',
		'giatien'
    ];
    public function dinhdang(){
    	return $this->hasOne('Model\DinhDangPhim','Gia_id','id');
    }
    public function loaighe(){
    	return $this->hasOne('Model\LoaiGhe','gia_id','id');
    }
}
