<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class LoaiGhe extends Model
{
    use SoftDeletes;

    protected $dates = ['deleted_at'];
    
    protected $fillable = [
    	'Tenloaighe',
		'gia_id'
    ];

    protected function gia()
	{
		$this->belongsTo('Model\Gia','gia_id');
	}

	protected function loaighe()
	{
		$this->hasOne('Model\LoaiGhe','gia_id');
	}

	protected function dinhdang()
	{
		$this->hasOne('Model\DinhDang','Gia_id');
	}
}
