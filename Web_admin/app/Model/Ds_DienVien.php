<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class Ds_DienVien extends Model
{
	use SoftDeletes;
	protected $dates = ['deleted_at'];

    protected $fillable = [
		'dienvien_id',
        'phim_id'
    ];

    public function dienvien(){
    	return $this->belongsToMany('Model\DienVien','dienvien_id');
    }

    public function phim(){
    	return $this->belongsto('Model\Phim','phim_id');
    }
}
