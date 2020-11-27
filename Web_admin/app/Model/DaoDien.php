<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class DaoDien extends Model
{
	use SoftDeletes;
	protected $dates = ['deleted_at'];

    protected $fillable = [
    	'Tendaodien',
		'Ngaysinh',
		'Gioitinh'
    ];

    public function phims(){
    	return $this->hasMany('Model\Phim','daodien_id','id');
    }
}
