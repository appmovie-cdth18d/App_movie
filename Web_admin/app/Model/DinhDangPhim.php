<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class DinhDangPhim extends Model
{
	use SoftDeletes;

	protected $dates = ['deleted_at'];

 	protected $fillable = [
    	'Loaidinhdang',
		'Gia_id'
    ];

	protected function gia()
	{
		$this->belongsTo('Model\Gia','Gia_id');
	}

    public function phims(){
    	return $this->hasMany('Model\Phim','dinhdang_id','id');
    }
}
