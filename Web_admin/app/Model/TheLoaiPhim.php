<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class TheLoaiPhim extends Model
{
	use SoftDeletes;

	protected $dates = ['deleted_at'];
	
	protected $fillable = ['Tentheloai'];

	public function phims(){
    	return $this->hasMany('Model\Phim','Theloai_id','id');
    }
}
