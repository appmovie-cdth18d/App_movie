<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class DienVien extends Model
{
	use SoftDeletes;
	protected $dates = ['deleted_at'];

    protected $fillable = [
    	'Tendienvien',
		'Ngaysinh',
		'Gioitinh'
    ];

    public function ds_dienviens(){
    	return $this->hasMany('Model\Ds_DienVien','dienvien_id','id');
    }
}
